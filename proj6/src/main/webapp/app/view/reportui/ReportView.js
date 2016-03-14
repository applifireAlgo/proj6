Ext.define('Proj6.view.reportui.ReportView', {
	extend : 'Ext.panel.Panel',
	requires : [ 'Proj6.view.reportui.querycriteria.QueryCriteriaView',
			'Proj6.view.reportui.datachart.DataChartViewTab',
			'Proj6.view.reportui.datachart.DataChartViewPanel',
			'Proj6.view.reportui.ReportViewController' ,
			'Proj6.view.fw.MainDataPointPanel',
			'Proj6.view.googlemaps.map.MapPanel'
			],
	xtype : 'reportview',
	controller : 'reportviewController',
	layout : 'border',
	isCustomReport:false,
	reportWidgets :["1","2","3","4"],
	//autoScroll : true,
	//margin : '3 0 5 0',
	height:500,
	width:"100%",
	listeners : {
		scope : 'controller',
		afterrender : 'renderReport'
	}
});
