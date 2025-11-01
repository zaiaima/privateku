$(function() {
		//页面加载
		getPage(1, true);
		
		//获取完成分页数据
		function getPage(page, isPaging){
			var param = {};
			param.name = $('#txtName').val();
			param.job = $('#sltJob').val();
			param.page = page;
			$.ajax({
				type : "POST",
				url : "EmpSearchServlet",
				data : param,
				dataType : "json",
				success : function(msg) {
					console.log(msg);
					//绑定列表
					listBind(msg.pageData);					
					//绑定页码
					if(isPaging){
						$("#paging").pagination({
							currentPage: msg.crtPage,
							totalPage: msg.totalPage,
							count: 10,
							callback: function(current) {
								getPage(current, false);
							}
						});
					}
				}
			});
		}

		//搜索功能
		$('#btnSearch').click(function() {
			getPage(1, false);
		});

		$.ajax({
			type : "POST",
			url : "EmpJobServlet",
			data : "",
			dataType : "json",
			success : function(msg) {
				var obj = $('#sltJob');
				for (var i = 0; i < msg.length; i++) {
					obj.append('<option value="'+msg[i]+'">' + msg[i]
							+ '</option>');
				}
			}
		});

		/* 列表数据绑定 */
		function listBind(data) {
			var str = "";
			for ( var i in data) {
				str += "<tr><td>" + data[i].empNo + "</td><td>" + data[i].eName
						+ "</td><td>" + data[i].job + "</td><td>" + data[i].sal
						+ "</td><td>" + data[i].dept.dName + "</td></tr>";
			}
			$('#list tbody').html(str);
		}
	});