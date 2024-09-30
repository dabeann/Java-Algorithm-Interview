package week27;

import java.util.*;
import java.util.stream.Collectors;

public class 주차_요금_계산_98 {
    public int[] solution(int[] fees, String[] records) {

        Map<String, String> inCar = new HashMap<>(); // 들어온 차 시간
        Map<String, Integer> parkTime = new HashMap<>(); // 번호당 누적 주차 시간
        Map<String, Integer> fee = new HashMap<>(); // 주차 요금

        for (String record : records) {
            String time = record.split(" ")[0];
            String car = record.split(" ")[1];
            String inOrOut = record.split(" ")[2];

            if (inOrOut.equals("IN")) {
                inCar.put(car, time);
            } else if (inOrOut.equals("OUT")) {
                // incar에 있는 값 보고 시간 계산해서 parkTime에 넣기
                String inTime = inCar.get(car);
                inCar.remove(car);
                int parkingTime = calParkingTime(inTime, time);
                parkTime.put(car, parkTime.getOrDefault(car, 0) + parkingTime);
            }
        }

        // inCar에 남아있는 차량 처리 (입차하고 출차 안 한 경우)
        for (String inCarNumber : inCar.keySet()) {
            String inTime = inCar.get(inCarNumber);
            int parkingTime = calParkingTime(inTime, "23:59");
            parkTime.put(inCarNumber, parkTime.getOrDefault(inCarNumber, 0) + parkingTime);
        }

        // fee 계산
        // 기본 시간, 기본 요금, 단위 시간, 단위 요금
        Set<String> parkTimeKey = parkTime.keySet();
        for (String timeCarNumber : parkTimeKey) {
            int time = parkTime.get(timeCarNumber);
            if (time <= fees[0]) {
                fee.put(timeCarNumber, fees[1]);
            } else {
                int extraTime = time - fees[0];
                int extraFee = (int) Math.ceil((double) extraTime / fees[2]) * fees[3];
                fee.put(timeCarNumber, fees[1] + extraFee);
            }
        }

        List<String> sorted = fee.keySet().stream().sorted().collect(Collectors.toList());
        int[] answer = new int[fee.size()];
        int index = 0;
        for (String carNumber : sorted) {
            answer[index++] = fee.get(carNumber);
        }

        return answer;
    }

    private int calParkingTime(String in, String out) {
        int inHour = Integer.parseInt(in.split(":")[0]);
        int inMin = Integer.parseInt(in.split(":")[1]);
        int outHour = Integer.parseInt(out.split(":")[0]);
        int outMin = Integer.parseInt(out.split(":")[1]);

        int totalInMinutes = inHour * 60 + inMin;
        int totalOutMinutes = outHour * 60 + outMin;

        return totalOutMinutes - totalInMinutes;
    }
}
