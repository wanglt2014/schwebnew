<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<div class="md_61575_j_map">
	<!-- <div class="md_hd"><span class="mh_title">直播地图</span> </div> -->
	<div class="md_bd">
		<div id="mapArea" class="maparea"></div>
	</div>

	<SCRIPT LANGUAGE="JavaScript">
		var jq = jQuery;
		function fnMap(div, data) {
			var obj = jq("#" + div);
			data = jq(data);
			var items = data.find("item"), len = items.length;
			function showmap() {
				var str = "";
				for ( var i = 0; i < len; i++) {
					var side = items[i].getAttribute("side");
					if (side == 1) {
						str += '<div class="map side1 '
								+ items[i].getAttribute("class")
								+ '"><a href="' + items[i].getAttribute("href")
								+ '" target="_blank">'
								+ items[i].getAttribute("title") + '</a></div>';
					} else if (side == 2) {
						str += '<div class="map side2 '
								+ items[i].getAttribute("class")
								+ '"><a href="' + items[i].getAttribute("href")
								+ '" target="_blank">'
								+ items[i].getAttribute("title") + '</a></div>';
					} else {
						str += '<div class="map '
								+ items[i].getAttribute("class")
								+ '"><a href="' + items[i].getAttribute("href")
								+ '" target="_self">'
								+ items[i].getAttribute("title") + '</a></div>';
					}
				}
				obj.html(str);
			}
			//初始化
			showmap();
			var maps = obj.find(">div"), temp = 0, list = jq('<div class="box2"></div>');
			maps.hover(function() {
				maps.css("z-index", "0");
				jq(this).css("z-index", "999");
				temp = maps.index(jq(this)[0]);
				var text = jq(jq(items[temp]).text());
				list.append(text);
				jq(this).append(list);
			}, function() {
				list.remove();
				list = jq('<div class="box2"></div>');
			});
		}
		jQuery(function() {
			//jQuery.get("/cus/bussiness/mapData2.xml", function(d) {
				jQuery.get("Marking_getxml", function(d) {
				fnMap("mapArea", d);
			});
		});
	</SCRIPT>
</div>