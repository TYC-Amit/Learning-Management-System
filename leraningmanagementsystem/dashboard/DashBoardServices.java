package com.te.leraningmanagementsystem.dashboard;

import java.util.Map;

public interface DashBoardServices {

	Map<String, Long> pichart(String batchId);

	Map<String, Long> barGraph(String batchId);

//	Map<String, Long> barGraphExperience(String batchId);

	Map<String, Long> barGraphDegree(String batchId);

//	Map<String, Long> barGraphforExperience(String batchId);

	Map<String, Long> barGraphExperience(String batchId);

}
