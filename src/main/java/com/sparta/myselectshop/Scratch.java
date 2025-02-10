package com.sparta.myselectshop;
class Scratch {
    public static void main(String[] args) {
        // 측정 시작 시간
        long startTime = System.currentTimeMillis();

        // 함수 수행
        long output = sumFromOneTo(1_000_000_000);

        // 측정 종료 시간
        long endTime = System.currentTimeMillis();

        long runTime = endTime - startTime;
        System.out.println("소요시간: " + runTime);
    }

    private static long sumFromOneTo(long input) {
        long output = 0;

        for (int i = 1; i < input; ++i) {
            output = output + i;
        }

        return output;
    }
}