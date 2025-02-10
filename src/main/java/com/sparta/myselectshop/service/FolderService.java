package com.sparta.myselectshop.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sparta.myselectshop.dto.FolderResponseDto;
import com.sparta.myselectshop.entity.Folder;
import com.sparta.myselectshop.entity.User;
import com.sparta.myselectshop.repository.FolderRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class FolderService {
    
    private final FolderRepository folderRepository;

    public void addFolders(List<String> foldernames, User user) {
        List<Folder> existFolderList = folderRepository.findAllByUserAndNameIn(user, foldernames);

        List<Folder> folderList = new ArrayList<>();

        for (String foldername : foldernames) {
            if (!isExistFolderName(foldername, existFolderList)) {
                Folder folder = new Folder(foldername, user);
                folderList.add(folder);
            }else{
                throw new IllegalArgumentException("중복된 폴더명을 제거해주세요. 폴더명 : "+foldername);
            }
        }
        folderRepository.saveAll(folderList);
    }
    
    public List<FolderResponseDto> getFolders(User user) {
        List<Folder> folderList = folderRepository.findAllByUser(user);
        List<FolderResponseDto> responseDtoList = new ArrayList<>();

        for (Folder folder : folderList) {
            responseDtoList.add(new FolderResponseDto(folder));
        }
        return responseDtoList;
    }

    private boolean isExistFolderName(String foldername, List<Folder> existFolderList) {
        for (Folder existFolder : existFolderList) {
            if(foldername.equals(existFolder.getName())){
                return true;
            }
        }
        return false;
    }




    
}
