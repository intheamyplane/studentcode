package com.techelevator.projects.dao;

import com.techelevator.projects.model.Timesheet;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class JdbcTimesheetDaoTests extends BaseDaoTests {

    private static final Timesheet TIMESHEET_1 = new Timesheet(1, 1, 1,
            LocalDate.parse("2021-01-01"), 1.0, true, "Timesheet 1");
    private static final Timesheet TIMESHEET_2 = new Timesheet(2, 1, 1,
            LocalDate.parse("2021-01-02"), 1.5, true, "Timesheet 2");
    private static final Timesheet TIMESHEET_3 = new Timesheet(3, 2, 1,
            LocalDate.parse("2021-01-01"), 0.25, true, "Timesheet 3");
    private static final Timesheet TIMESHEET_4 = new Timesheet(4, 2, 2,
            LocalDate.parse("2021-02-01"), 2.0, false, "Timesheet 4");

    private JdbcTimesheetDao dao;

    private Timesheet testTimesheet;


    @Before

    public void setup() {
        dao = new JdbcTimesheetDao(dataSource);
        testTimesheet = new Timesheet(5, 2, 2, LocalDate.now(), 1.0, false, "Timesheet 5");
    }

    @Test
    public void getTimesheet_returns_correct_timesheet_for_id() {
        Timesheet timesheet = dao.getTimesheet(1);
        assertTimesheetsMatch(TIMESHEET_1, timesheet);

        timesheet = dao.getTimesheet(2);
        assertTimesheetsMatch(TIMESHEET_2, timesheet);
    }

    @Test
    public void getTimesheet_returns_null_when_id_not_found() {
        Timesheet timesheet = dao.getTimesheet(55);
        Assert.assertNull(timesheet);
    }

    @Test
    public void getTimesheetsByEmployeeId_returns_list_of_all_timesheets_for_employee() {
        List<Timesheet> timesheets = dao.getTimesheetsByEmployeeId(1);
        assertEquals(2, timesheets.size());
        assertTimesheetsMatch(TIMESHEET_1, timesheets.get(0));
        assertTimesheetsMatch(TIMESHEET_2, timesheets.get(1));


        timesheets = dao.getTimesheetsByEmployeeId(2);
        assertEquals(2, timesheets.size());
        assertTimesheetsMatch(TIMESHEET_3, timesheets.get(0));
        assertTimesheetsMatch(TIMESHEET_4, timesheets.get(1));

    }

    @Test
    public void getTimesheetsByProjectId_returns_list_of_all_timesheets_for_project() {
        List<Timesheet> timesheets = dao.getTimesheetsByProjectId(1);
        assertEquals(3, timesheets.size());
        assertTimesheetsMatch(TIMESHEET_1, timesheets.get(0));
        assertTimesheetsMatch(TIMESHEET_3, timesheets.get(2));

        timesheets = dao.getTimesheetsByProjectId(2);
        assertEquals(1, timesheets.size());
        assertTimesheetsMatch(TIMESHEET_4, timesheets.get(0));
    }

    @Test
    public void createTimesheet_returns_timesheet_with_id_and_expected_values() {

        Timesheet createdTimesheet = dao.createTimesheet(testTimesheet);
        Assert.assertNotNull(createdTimesheet);
        int idOfCreatedTimesheet = createdTimesheet.getTimesheetId();

        Assert.assertTrue(idOfCreatedTimesheet > 0);
        testTimesheet.setTimesheetId(idOfCreatedTimesheet);
        assertTimesheetsMatch(testTimesheet, createdTimesheet);
    }

    @Test
    public void created_timesheet_has_expected_values_when_retrieved() {
        Timesheet createdTimesheet = dao.createTimesheet(testTimesheet);
        int idCreatedTimesheet = createdTimesheet.getTimesheetId();
        Timesheet result = dao.getTimesheet(idCreatedTimesheet);

        assertTimesheetsMatch(createdTimesheet, result);
    }

    @Test
    public void updated_timesheet_has_expected_values_when_retrieved() {
        Timesheet timesheetToUpdate = dao.getTimesheet(1);
        timesheetToUpdate.setHoursWorked(2);
        timesheetToUpdate.setDescription("timesheet_1_updated");
        timesheetToUpdate.setBillable(false);

        dao.updateTimesheet(timesheetToUpdate);
        Timesheet updatedTimesheet = dao.getTimesheet(1);

        assertTimesheetsMatch(timesheetToUpdate, updatedTimesheet);
    }

    @Test
    public void deleted_timesheet_cant_be_retrieved() {
        dao.deleteTimesheet(2);
        Timesheet retrievedTimesheet = dao.getTimesheet(2);
        Assert.assertNull(retrievedTimesheet);

        List<Timesheet> timesheets = dao.getTimesheetsByProjectId(1);
        assertEquals(2, timesheets.size());



    }

    @Test
    public void getBillableHours_returns_correct_total() {
        Double timesheet = dao.getBillableHours(1, 1);
        Assert.assertEquals(2.5, timesheet, 0.01 );

        Double test = dao.getBillableHours(2, 1);
        Assert.assertEquals(0.25, test, 0.01);


    }

    private void assertTimesheetsMatch(Timesheet expected, Timesheet actual) {
        assertEquals(expected.getTimesheetId(), actual.getTimesheetId());
        assertEquals(expected.getEmployeeId(), actual.getEmployeeId());
        assertEquals(expected.getProjectId(), actual.getProjectId());
        assertEquals(expected.getDateWorked(), actual.getDateWorked());
        assertEquals(expected.getHoursWorked(), actual.getHoursWorked(), 0.001);
        assertEquals(expected.isBillable(), actual.isBillable());
        assertEquals(expected.getDescription(), actual.getDescription());
    }

}
