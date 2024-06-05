package week13;

import java.util.*;

public class 여행_경로_42 {
    public String[] solution(String[][] tickets) {
        Map<String, PriorityQueue<String>> flightsMap = new HashMap<>();
        List<String> itinerary = new LinkedList<>();

        for (String[] ticket : tickets) {
            flightsMap.computeIfAbsent(ticket[0], k -> new PriorityQueue<>()).add(ticket[1]);
        }

        Deque<String> stack = new ArrayDeque<>();
        stack.push("ICN");

        while (!stack.isEmpty()) {
            String airport = stack.peek();
            PriorityQueue<String> destinations = flightsMap.get(airport);
            if (destinations != null && !destinations.isEmpty()) {
                stack.push(destinations.poll());
            } else {
                itinerary.add(0, stack.pop());
            }
        }

        return itinerary.toArray(new String[0]);
    }
}
