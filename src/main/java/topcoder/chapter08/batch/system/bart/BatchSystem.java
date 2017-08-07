package topcoder.chapter08.batch.system.bart;

import java.util.*;

public class BatchSystem {

	class Task implements Comparable<Task> {
		private String requester;
		private int totalTime;
		private List<Integer> taskIds = new ArrayList<>();

		Task(String name,int time,int id) {
			this.requester = name;
			this.totalTime = time;
			this.taskIds.add(id);
		}

		@Override
		public int compareTo(Task another) {
			int result = this.totalTime - another.totalTime;
			if(result == 0) {
				return this.requester.compareTo(another.requester);
			}
			return result;
		}
	}

	public int[] schedule(int[] duration, String[] user) {
		Map<String,Task> taskMap = new HashMap<>();
		for(int i = 0; i < duration.length; i++) {
			if(taskMap.containsKey(user[i])) {
				Task saveOne = taskMap.get(user[i]);
				saveOne.totalTime += duration[i];
				saveOne.taskIds.add(i);
				continue;
			}

			Task task = new Task(user[i], duration[i], i);
			taskMap.put(user[i], task);
		}

		return taskMap.values().stream()
			.sorted(Task::compareTo)
			.map(task -> task.taskIds)
			.flatMap(List::stream)
			.mapToInt(i -> i)
			.toArray();
	}
}
