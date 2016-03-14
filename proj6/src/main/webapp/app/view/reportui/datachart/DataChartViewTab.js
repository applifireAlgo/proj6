Ext.define('Proj6.view.reportui.datachart.DataChartViewTab', {
	extend : 'Ext.tab.Panel',
	requires : [ 'Proj6.view.reportui.datachart.DataChartTController',
	             'Proj6.view.reportui.datachart.datagrid.DataGridView',
	             'Proj6.view.reportui.datachart.chart.ChartTabView',
	             'Proj6.view.reportui.datachart.ChartPointView' ],
	controller : 'datacharttController',
	xtype : 'datachart-tabpanel',
	tabPosition : 'bottom',
	bodyStyle : 'background:#D8D8D8',
	listeners : {
		scope : "controller",
		tabchange : 'tabchange',
		afterrender:'afterTabPanelRender'
	}
});