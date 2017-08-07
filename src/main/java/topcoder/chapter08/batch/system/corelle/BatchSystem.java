package topcoder.chapter08.batch.system.corelle;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.ArrayUtils;

/**
 * Created by noblesm on 2017. 8. 7..
 */
public class BatchSystem {

	public static void main(String[] args) {
		BatchSystem batchSystem = new BatchSystem();
		batchSystem.print(new int[] { 400, 100, 100, 100 }, new String[] { "Danny", "Stella", "Stella", "Mac" });
		batchSystem.print(new int[] { 200, 200, 200 }, new String[] { "G", "S", "W" });
		batchSystem.print(new int[] { 100, 200, 50 }, new String[] { "H", "h", "Y" });
	}

	private void print(int[] duration, String[] user) {
		System.out.println(ArrayUtils.toString(schedule(duration, user)));
	}

	public int[] schedule(int[] duration, String[] user) {
		Map<String, Task> map = Maps.newHashMap();

		for (int i = 0; i < user.length; i++) {
			if (map.containsKey(user[i])) {
				Task containTask = map.get(user[i]);
				containTask.addDuration(duration[i]);
				containTask.addIds(i);
			} else {
				map.put(user[i], new Task(user[i], duration[i], Lists.newArrayList(i)));
			}
		}

		return map.values().stream()
			.sorted(TASK_COMPARATOR)
			.map(Task::getIds)
			.flatMap(Collection::stream)
			.mapToInt(value -> value)
			.toArray();
	}

	private static final Comparator<Task> TASK_COMPARATOR = (o1, o2) -> {
		if (o1.getTotalDuration() == o2.getTotalDuration()) {
			return o1.getUserName().compareTo(o2.getUserName());
		}
		return o1.getTotalDuration() - o2.getTotalDuration();
	};

	private class Task {
		private String userName;
		private int totalDuration;
		private List<Integer> ids = Lists.newArrayList();

		public Task(String userName, int totalDuration, List<Integer> ids) {
			this.userName = userName;
			this.totalDuration = totalDuration;
			this.ids = ids;
		}

		public void addDuration(int duration) {
			totalDuration += duration;
		}

		public void addIds(int id) {
			ids.add(id);
		}

		public String getUserName() {
			return userName;
		}

		public int getTotalDuration() {
			return totalDuration;
		}

		public List<Integer> getIds() {
			return ids;
		}
	}
}
