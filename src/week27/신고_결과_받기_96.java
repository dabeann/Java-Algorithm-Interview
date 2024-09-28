package week27;

import java.util.*;

public class 신고_결과_받기_96 {
    public int[] solution(String[] id_list, String[] report, int k){
        int[] answer = new int[id_list.length];
        Map<String, Set<String>> reporterMap = new HashMap<>();
        Map<String, Integer> reportedCount = new HashMap<>();

        // 신고 정보 중복 제거
        Set<String> uniqueReports = new HashSet<>(Arrays.asList(report));

        // 신고 정보 처리
        for (String reportInfo : uniqueReports) {
            String[] parts = reportInfo.split(" ");
            String reporter = parts[0];  // 신고한 유저
            String reported = parts[1];  // 신고당한 유저

            // 신고한 유저 정보 저장
            reporterMap.putIfAbsent(reporter, new HashSet<>());
            reporterMap.get(reporter).add(reported);

            // 신고당한 유저의 신고 횟수 증가
            reportedCount.put(reported, reportedCount.getOrDefault(reported, 0) + 1);
        }

        // 정지된 유저 확인 및 메일 수 계산
        for (String reportedUser : reportedCount.keySet()) {
            if (reportedCount.get(reportedUser) >= k) {
                // 신고한 유저 중 정지된 유저를 신고한 유저에게 메일 발송
                for (String reporter : reporterMap.keySet()) {
                    if (reporterMap.get(reporter).contains(reportedUser)) {
                        answer[Arrays.asList(id_list).indexOf(reporter)]++;
                    }
                }
            }
        }

        return answer;
    }
}
