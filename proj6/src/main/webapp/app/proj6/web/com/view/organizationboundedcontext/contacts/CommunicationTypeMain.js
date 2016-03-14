Ext.define('Proj6.proj6.web.com.view.organizationboundedcontext.contacts.CommunicationTypeMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "CommunicationTypeMainController",
     "restURL": "/CommunicationType",
     "defaults": {
          "split": true
     },
     "requires": ["Proj6.proj6.shared.com.model.organizationboundedcontext.contacts.CommunicationTypeModel", "Proj6.proj6.web.com.controller.organizationboundedcontext.contacts.CommunicationTypeMainController", "Proj6.proj6.shared.com.model.organizationboundedcontext.contacts.CommunicationGroupModel", "Proj6.proj6.shared.com.viewmodel.organizationboundedcontext.contacts.CommunicationTypeViewModel"],
     "communicationLog": [],
     "tabPosition": "bottom",
     "items": [{
          "title": "Data Browser",
          "layout": "border",
          "defaults": {
               "split": true
          },
          "autoScroll": false,
          "customWidgetType": "vdBorderLayout",
          "items": [{
               "xtype": "tabpanel",
               "customWidgetType": "vdTabLayout",
               "margin": "5 0 5 5",
               "border": 1,
               "style": {
                    "borderColor": "#f6f6f6",
                    "borderStyle": "solid",
                    "borderWidth": "1px"
               },
               "displayName": "Communication Type",
               "name": "CommunicationTypeTreeContainer",
               "itemId": "CommunicationTypeTreeContainer",
               "restURL": "/CommunicationType",
               "autoScroll": false,
               "collapsible": true,
               "titleCollapse": true,
               "collapseMode": "header",
               "collapsed": false,
               "items": [{
                    "xtype": "treepanel",
                    "customWidgetType": "vdTree",
                    "title": "Browse",
                    "name": "entityTreePanel",
                    "useArrows": true,
                    "rootVisible": false,
                    "itemId": "CommunicationTypeTree",
                    "listeners": {
                         "select": "treeClick"
                    },
                    "tbar": [{
                         "xtype": "triggerfield",
                         "customWidgetType": "vdTriggerField",
                         "emptyText": "Search",
                         "triggerCls": "",
                         "listeners": {
                              "change": "onTriggerfieldChange",
                              "buffer": 250
                         }
                    }, "->", {
                         "xtype": "tool",
                         "type": "refresh",
                         "tooltip": "Refresh Tree Data",
                         "handler": "onTreeRefreshClick"
                    }]
               }, {
                    "title": "Advance Search",
                    "xtype": "form",
                    "customWidgetType": "vdFormpanel",
                    "itemId": "queryPanel",
                    "dockedItems": [{
                         "xtype ": "toolbar",
                         "customWidgetType": "vdBBar",
                         "dock": "bottom",
                         "isDockedItem": true,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill"
                         }, {
                              "xtype": "button",
                              "customWidgetType": "vdButton",
                              "text": "Filter",
                              "name": "filterButton",
                              "handler": "onFilterClick"
                         }]
                    }],
                    "items": [{
                         "name": "commTypeName",
                         "itemId": "commTypeName",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Communication Type Name",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Communication Type Name",
                         "fieldId": "73F94844-8849-4072-BDCF-1C66DC26817F",
                         "minLength": "0",
                         "maxLength": "128",
                         "errorMessage": "Please enter communication type",
                         "bindable": "commTypeName"
                    }]
               }],
               "region": "west",
               "width": "20%"
          }, {
               "region": "center",
               "layout": "border",
               "defaults": {
                    "split": true
               },
               "customWidgetType": "vdBorderLayout",
               "items": [{
                    "customWidgetType": "vdFormpanel",
                    "xtype": "form",
                    "displayName": "Communication Type",
                    "title": "Communication Type",
                    "name": "CommunicationType",
                    "itemId": "CommunicationTypeForm",
                    "bodyPadding": 10,
                    "items": [{
                         "name": "commType",
                         "itemId": "commType",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "commType",
                         "margin": "5 5 5 5",
                         "fieldLabel": "commType<font color='red'> *<\/font>",
                         "fieldId": "2F3B96E6-69DE-4167-AC9A-17C57A954EED",
                         "minLength": "0",
                         "maxLength": "64",
                         "hidden": true,
                         "value": "",
                         "bindable": "commType"
                    }, {
                         "name": "commTypeName",
                         "itemId": "commTypeName",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Communication Type Name",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Communication Type Name<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "73F94844-8849-4072-BDCF-1C66DC26817F",
                         "minLength": "0",
                         "maxLength": "128",
                         "errorMessage": "Please enter communication type",
                         "bindable": "commTypeName",
                         "columnWidth": 0.5
                    }, {
                         "name": "commTypeDescription",
                         "itemId": "commTypeDescription",
                         "xtype": "textareafield",
                         "customWidgetType": "vdTextareafield",
                         "displayName": "Communication Type Description",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Communication Type Description",
                         "fieldId": "A8AB3512-85BE-4781-9ABF-7BFBDBF79D8C",
                         "bindable": "commTypeDescription",
                         "columnWidth": 0.5
                    }, {
                         "name": "commGroupId",
                         "itemId": "commGroupId",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "Communication Group",
                         "margin": "5 5 5 5",
                         "valueField": "primaryKey",
                         "displayField": "primaryDisplay",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Proj6.proj6.shared.com.model.organizationboundedcontext.contacts.CommunicationGroupModel"
                         },
                         "allowBlank": false,
                         "fieldLabel": "Communication Group<font color='red'> *<\/font>",
                         "fieldId": "08F87E62-3684-4BF6-8938-87683622A74B",
                         "restURL": "CommunicationGroup",
                         "bindable": "commGroupId",
                         "columnWidth": 0.5
                    }, {
                         "name": "versionId",
                         "itemId": "versionId",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "versionId",
                         "margin": "5 5 5 5",
                         "value": "-1",
                         "fieldLabel": "versionId",
                         "fieldId": "CF336F20-B21F-445E-B1AB-B051E03F66C1",
                         "bindable": "versionId",
                         "hidden": true
                    }],
                    "layout": "column",
                    "defaults": {
                         "columnWidth": 0.5,
                         "labelAlign": "left",
                         "labelWidth": 200
                    },
                    "autoScroll": true,
                    "dockedItems": [{
                         "xtype ": "toolbar",
                         "customWidgetType": "vdBBar",
                         "dock": "bottom",
                         "ui": "footer",
                         "isDockedItem": true,
                         "parentId": 1,
                         "customId": 95,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 95,
                              "customId": 725
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "name": "saveFormButton",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 95,
                              "customId": 726,
                              "listeners": {
                                   "click": "saveForm"
                              }
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "name": "resetFormButton",
                              "margin": "0 5 0 5",
                              "text": "Reset",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "resetFormButton",
                              "parentId": 95,
                              "customId": 727,
                              "listeners": {
                                   "click": "resetForm"
                              }
                         }],
                         "defaults": {}
                    }],
                    "listeners": {
                         "scope": "controller"
                    },
                    "tools": [{
                         "type": "help",
                         "tooltip": "Console",
                         "handler": "onConsoleClick"
                    }, {
                         "type": "refresh",
                         "tooltip": "Refresh Tab",
                         "handler": "init"
                    }],
                    "extend": "Ext.form.Panel",
                    "region": "center"
               }, {
                    "xtype": "gridpanel",
                    "customWidgetType": "vdGrid",
                    "displayName": "Communication Type",
                    "title": "Details Grid",
                    "name": "CommunicationTypeGrid",
                    "itemId": "CommunicationTypeGrid",
                    "restURL": "/CommunicationType",
                    "store": [],
                    "bodyPadding": 10,
                    "columns": [{
                         "header": "commType",
                         "dataIndex": "commType",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "primaryDisplay",
                         "dataIndex": "primaryDisplay",
                         "hidden": true
                    }, {
                         "header": "primaryKey",
                         "dataIndex": "primaryKey",
                         "hidden": true
                    }, {
                         "header": "Communication Type Name",
                         "dataIndex": "commTypeName",
                         "flex": 1
                    }, {
                         "header": "Communication Type Description",
                         "dataIndex": "commTypeDescription",
                         "flex": 1
                    }, {
                         "header": "Communication Group",
                         "dataIndex": "commGroupId",
                         "renderer": "renderFormValue",
                         "flex": 1
                    }, {
                         "header": "createdBy",
                         "dataIndex": "createdBy",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "createdDate",
                         "dataIndex": "createdDate",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "updatedBy",
                         "dataIndex": "updatedBy",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "updatedDate",
                         "dataIndex": "updatedDate",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "versionId",
                         "dataIndex": "versionId",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "activeStatus",
                         "dataIndex": "activeStatus",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "txnAccessCode",
                         "dataIndex": "txnAccessCode",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "xtype": "actioncolumn",
                         "customWidgetType": "vdActionColumn",
                         "width": 30,
                         "sortable": false,
                         "menuDisable": true,
                         "items": [{
                              "icon": "images/delete.gif",
                              "tooltip": "Delete Record",
                              "handler": "onDeleteActionColumnClickMainGrid"
                         }]
                    }],
                    "listeners": {
                         "itemclick": "onGridItemClick"
                    },
                    "tools": [{
                         "type": "refresh",
                         "tooltip": "Refresh Grid Data",
                         "handler": "onGridRefreshClick"
                    }],
                    "collapsible": true,
                    "titleCollapse": true,
                    "collapseMode": "header",
                    "region": "south",
                    "height": "40%"
               }]
          }]
     }, {
          "title": "Add New",
          "itemId": "addNewForm",
          "layout": "border",
          "customWidgetType": "vdBorderLayout",
          "autoScroll": false,
          "items": [{
               "customWidgetType": "vdFormpanel",
               "xtype": "form",
               "displayName": "Communication Type",
               "title": "Communication Type",
               "name": "CommunicationType",
               "itemId": "CommunicationTypeForm",
               "bodyPadding": 10,
               "items": [{
                    "name": "commType",
                    "itemId": "commType",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "commType",
                    "margin": "5 5 5 5",
                    "fieldLabel": "commType<font color='red'> *<\/font>",
                    "fieldId": "2F3B96E6-69DE-4167-AC9A-17C57A954EED",
                    "minLength": "0",
                    "maxLength": "64",
                    "hidden": true,
                    "value": "",
                    "bindable": "commType"
               }, {
                    "name": "commTypeName",
                    "itemId": "commTypeName",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Communication Type Name",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Communication Type Name<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "73F94844-8849-4072-BDCF-1C66DC26817F",
                    "minLength": "0",
                    "maxLength": "128",
                    "errorMessage": "Please enter communication type",
                    "bindable": "commTypeName",
                    "columnWidth": 0.5
               }, {
                    "name": "commTypeDescription",
                    "itemId": "commTypeDescription",
                    "xtype": "textareafield",
                    "customWidgetType": "vdTextareafield",
                    "displayName": "Communication Type Description",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Communication Type Description",
                    "fieldId": "A8AB3512-85BE-4781-9ABF-7BFBDBF79D8C",
                    "bindable": "commTypeDescription",
                    "columnWidth": 0.5
               }, {
                    "name": "commGroupId",
                    "itemId": "commGroupId",
                    "xtype": "combo",
                    "customWidgetType": "vdCombo",
                    "displayName": "Communication Group",
                    "margin": "5 5 5 5",
                    "valueField": "primaryKey",
                    "displayField": "primaryDisplay",
                    "typeAhead": true,
                    "queryMode": "local",
                    "minChars": 2,
                    "store": {
                         "data": [],
                         "model": "Proj6.proj6.shared.com.model.organizationboundedcontext.contacts.CommunicationGroupModel"
                    },
                    "allowBlank": false,
                    "fieldLabel": "Communication Group<font color='red'> *<\/font>",
                    "fieldId": "08F87E62-3684-4BF6-8938-87683622A74B",
                    "restURL": "CommunicationGroup",
                    "bindable": "commGroupId",
                    "columnWidth": 0.5
               }, {
                    "name": "versionId",
                    "itemId": "versionId",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "versionId",
                    "margin": "5 5 5 5",
                    "value": "-1",
                    "fieldLabel": "versionId",
                    "fieldId": "CF336F20-B21F-445E-B1AB-B051E03F66C1",
                    "bindable": "versionId",
                    "hidden": true
               }],
               "layout": "column",
               "defaults": {
                    "columnWidth": 0.5,
                    "labelAlign": "left",
                    "labelWidth": 200
               },
               "autoScroll": true,
               "dockedItems": [{
                    "xtype ": "toolbar",
                    "customWidgetType": "vdBBar",
                    "dock": "bottom",
                    "ui": "footer",
                    "isDockedItem": true,
                    "parentId": 1,
                    "customId": 95,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill",
                         "parentId": 95,
                         "customId": 725
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "name": "saveFormButton",
                         "margin": "0 5 0 5",
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "parentId": 95,
                         "customId": 726,
                         "listeners": {
                              "click": "saveForm"
                         }
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "name": "resetFormButton",
                         "margin": "0 5 0 5",
                         "text": "Reset",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "resetFormButton",
                         "parentId": 95,
                         "customId": 727,
                         "listeners": {
                              "click": "resetForm"
                         }
                    }],
                    "defaults": {}
               }],
               "listeners": {
                    "scope": "controller"
               },
               "tools": [{
                    "type": "help",
                    "tooltip": "Console",
                    "handler": "onConsoleClick"
               }, {
                    "type": "refresh",
                    "tooltip": "Refresh Tab",
                    "handler": "init"
               }],
               "extend": "Ext.form.Panel",
               "region": "center"
          }]
     }]
});