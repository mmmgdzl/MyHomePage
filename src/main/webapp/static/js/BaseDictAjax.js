function getBaseDict(positionId, dictTypeCode, selectName, selectId) {
	var $position = $("#" + positionId);
	var $select = $("<select name='"+ selectName + "'></select>");
	$position.append($select);
	$select.append($("<option value=''>---请选择---</option>"));
	$.post(
		"${pageContext.request.contextPath}/baseDictAction",
		{"typeCode":dictTypeCode},
		function(data) {
			for(var i=0; i<data.length; i++) {
				var $option = $("<option value='" + data[i].dict_id + "'>" + data[i].dict_item_name + "</option>");
				if(data[i].dict_id == selectId) {
					$option.attr("selected", "selected");
				}
				$select.append($option);
			}
		},
		"json"
	);
	
}
