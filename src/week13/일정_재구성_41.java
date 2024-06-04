package week13;

import java.util.*;

public class 일정_재구성_41 {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> flightsMap = new HashMap<>();
        List<String> itinerary = new LinkedList<>();

        for (List<String> ticket : tickets) {
            flightsMap.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<>()).add(ticket.get(1));
        }

        Deque<String> stack = new ArrayDeque<>();
        stack.push("JFK");

        while (!stack.isEmpty()) {
            String airport = stack.peek();
            PriorityQueue<String> destinations = flightsMap.get(airport);
            if (destinations != null && !destinations.isEmpty()) {
                stack.push(destinations.poll());
            } else {
                itinerary.add(0, stack.pop());
            }
        }

        return itinerary;
    }
}
