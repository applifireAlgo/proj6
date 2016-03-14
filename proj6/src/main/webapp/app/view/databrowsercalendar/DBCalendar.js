Ext.define('Proj6.view.databrowsercalendar.DBCalendar', {
	extend : 'Proj6.view.databrowsercalendar.DBCalendarView',
	requires : [ 'Proj6.view.databrowsercalendar.DBCalendarController',
	             'Proj6.view.databrowsercalendar.DBCalendarView','Ext.layout.container.Card',
	             'Ext.calendar.view.Day', 'Ext.calendar.view.Week',
	             'Ext.calendar.view.Month',
	             'Ext.calendar.form.EventDetails',
	             'Ext.calendar.data.EventMappings'],
	controller : 'databrowsercalendar',
	items : [],
	listeners : {
		afterrender : 'loadData',
		scope : "controller"
	}
});
