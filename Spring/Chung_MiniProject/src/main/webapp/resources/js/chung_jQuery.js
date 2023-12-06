function connectSearchAddressEvent() {
	$("#join_c_addr1, #join_c_addr2").click(function() {
		new daum.Postcode({
			oncomplete : function(data) {
				$("#join_c_addr1").val(data.zonecode);
				$("#join_c_addr2").val(data.roadAddress);
			}
		}).open();
	});
}



function connectIdCheckEvent() {
	$("#join_c_id").keyup(function() {
		var c_id = $(this).val();
		$.getJSON("member.id.check?c_id="+c_id, function(memberJSON){
			if (memberJSON.member[0] == null) {
				$("#join_c_id").css("color", "black");
			} else {
				$("#join_c_id").css("color", "red");
			}
		});
	});
}

function connectSNSWriteAreaSummonEvent() {
	var swaVisible = false;
	$("#snsWriteAreaSummoner").click(function() {
		if (swaVisible) {
			$("#snsWriteArea").css("left", "-424px");
		} else {
			$("#snsWriteArea").css("left", "0px");
		}
		swaVisible = !swaVisible;
	});
	$("#snsWriteAreaSummoner2").click(function() {
		if (swaVisible) {
			$("#snsWriteArea2").css("left", "-413px");
		} else {
			$("#snsWriteArea2").css("left", "0px");
		}
		swaVisible = !swaVisible;
	});
}

function summonTitleArea() {
//	setTimeout(function() {
//		$("body").css("opacity", "1");
//	}, 700);

	setTimeout(function() {
		$("#siteTitleArea").css("top", "0px");
		setTimeout(function() {
			$("#siteMenuArea").css("left", "0px");
			setTimeout(function() {
				$("#siteLoginArea").css("right", "0px");
				setTimeout(function() {
					$("#siteSubTitle").css("opacity", "1");
					setTimeout(function() {
						$("#but").text("(어려운거)");
						setTimeout(function() {
							$("#but").text("(어려운거 알지만)");
							setTimeout(function() {
								$("#but").text("(어려운거 알지만 그래도)");
								setTimeout(function() {
									$("#but").css("color", "#eaeff9").css(
											"text-shadow",
											"#A1887F 2px 2px 2px");
								}, 1000);
							}, 700);
						}, 700);
					}, 1000);
				}, 1000);
			}, 200);
		}, 500);
	}, 700);
}





$(function() {
	connectSearchAddressEvent();
	connectSNSWriteAreaSummonEvent()
	connectIdCheckEvent();
	summonTitleArea();
});













