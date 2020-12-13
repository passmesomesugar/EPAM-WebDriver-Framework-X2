package com.mycompany.app.service;

import com.mycompany.app.model.CalculatorModel;

public class CalculatorModelCreator {
    public static final String TEST_DATA_NUMBER_OF_INSTANCES = "testdata.calculator.numberofinstances";
    public static final String TEST_DATA_SOFTWARE = "testdata.calculator.software";
    public static final String TEST_DATA_MACHINE_CLASS = "testdata.calculator.machineclass";
    public static final String TEST_DATA_SERIES = "testdata.calculator.series";
    public static final String TEST_DATA_MACHINE_TYPE = "testdata.calculator.machinetype";
    public static final String TEST_DATA_ADD_GPUS = "testdata.calculator.addgpu";
    public static final String TESTDATA_NUMBER_OF_GPUS = "testdata.calculator.numberofgpus";
    public static final String TESTDATA_GPU_TYPE = "testdata.calculator.gputype";
    public static final String TESTDATA_LOCAL_SSD = "testdata.calculator.localssd";
    public static final String TESTDATA_DATACENTER_LOCATION = "testdata.calculator.datacenterlocation";
    public static final String TESTDATA_COMMITTED_USAGE = "testdata.calculator.committedusage";
    public static final String TESTDATA_EXPECTED_ESTIMATE = "testdata.calculator.expectedestimate";

    public static CalculatorModel withCredentialsFromProperty() {
        return new CalculatorModel(TestDataReader.getTestData(TEST_DATA_NUMBER_OF_INSTANCES),
                TestDataReader.getTestData(TEST_DATA_SOFTWARE),
                TestDataReader.getTestData(TEST_DATA_MACHINE_CLASS),
                TestDataReader.getTestData(TEST_DATA_SERIES),
                TestDataReader.getTestData(TEST_DATA_MACHINE_TYPE),
                Boolean.parseBoolean(TestDataReader.getTestData(TEST_DATA_ADD_GPUS)),
                TestDataReader.getTestData(TESTDATA_NUMBER_OF_GPUS),
                TestDataReader.getTestData(TESTDATA_GPU_TYPE),
                TestDataReader.getTestData(TESTDATA_LOCAL_SSD),
                TestDataReader.getTestData(TESTDATA_DATACENTER_LOCATION),
                TestDataReader.getTestData(TESTDATA_COMMITTED_USAGE),
                Double.parseDouble(TestDataReader.getTestData(TESTDATA_EXPECTED_ESTIMATE)));
    }
}
