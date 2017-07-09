package topcoder.chapter07.salary.bart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CorporationSalary {

	private Map<Integer, SalaryMan> salaryManMap = new HashMap<>();
	private class SalaryMan {
		private static final int BASE_SALARY = 1;

		private List<SalaryMan> subordinateList = new ArrayList<>();
		private long salary = BASE_SALARY;

		List<SalaryMan> getSubordinateList() {
			return subordinateList;
		}

		long getSalary() {
			long sumSalary = subordinateList.stream()
				.map(SalaryMan::getSalary)
				.reduce(0L, (sum, salary) -> sum + salary);
			return sumSalary > BASE_SALARY ? sumSalary : salary;
		}
	}

	public long totalSalary(String[] relations) {
		return reduceSalary(convertToSalaryMan(relations));
	}

	private long reduceSalary(List<SalaryMan> salaryManList) {
		return salaryManList.stream()
			.map(SalaryMan::getSalary)
			.reduce(0L, (sum, salary) -> sum + salary);
	}

	private List<SalaryMan> convertToSalaryMan(String[] relations) {
		List<SalaryMan> salaryManList = new ArrayList<>();
		for(int i =0; i < relations.length; i++) {
			salaryManList.add(buildSalaryMan(i, relations));
		}
		return salaryManList;
	}

	private SalaryMan buildSalaryMan(int id, String[] relations ) {
		if(salaryManMap.containsKey(id)) {
			return salaryManMap.get(id);
		}

		SalaryMan man = new SalaryMan();
		char[] relationArr = relations[id].toCharArray();
		for(int i =0; i < relationArr.length; i++) {
			List<SalaryMan> subordinateList = man.getSubordinateList();
			if (relationArr[i] == 'Y') {
				SalaryMan subordinate = buildSalaryMan(i, relations);
				salaryManMap.put(i, subordinate);
				subordinateList.add(subordinate);
			}
		}

		return man;
	}
}
