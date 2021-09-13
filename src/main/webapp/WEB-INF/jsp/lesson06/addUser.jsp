<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<!-- bootstrap CDN link -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	
	<!-- ajax를 사용하려면 더 많은 함수가 있는 jquery js 포함해야 한다. -->
	<script src="//code.jquery.com/jquery-3.2.1.min.js"></script>
<!-- 	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script> -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>
<meta charset="UTF-8">
<title>회원정보추가</title>
</head>
<body>
	<div>
		<h1>회원정보추가</h1>

<!-- 아래의 submit을 사용하지 않기 위해 그리고 AJAX를 사용하기 위한 조치이다 -->		
<!-- 		<form id="form" action="/lesson06/ex01/add_user" method="post"> -->
			<b>이름: </b>
			<input type="text" class="form-control" name="name">
			<b>생년월일: </b>
			<input type="text" class="form-control" name="yyyymmdd">
			<b>이메일: </b>
			<input type="text" class="form-control" name="email">
			<b>자기소계: </b>
			<textarea rows="10" cols="30" class="form-control" name="introduce"></textarea>
<!--		<button type="submit" id="addBtn" class="btn">추가</button> -->
			<input type="button" id="addBtn" class="btn btn-success" value="추가"> <!-- AJAX를 사용하게 된다면 submit이 아니라 button을 사용해야한다. 매우 중요. -->
<!-- 		</form> -->
	</div>
	
	<script>
		$(document).ready(function(){
			alert("이건된다.")
			/* // (1) jquery의 submit 기능 이용하기
			$('#form').on('submit', function(e){
				//e.preventDefault();	// 기본으로 submit 되는 것을 막는다. 이걸하지 않으면 그냥 서브 및이 되버린다.
				alert("추가 버튼 클릭")
				
				// validation
				let name = $('input[name=name]').val().trim(); //이름 가져와서 앞뒤 여백 제거
				if(name =='') {
					alert("이름을 입력하세요.");
					return false;
				}
				
				let yyyymmdd = $('input[name=yyyymmdd]').val().trim()
				if(yyyymmdd =='') {
					alert("생년월일 입력하세요.");
					return false;
				}
				
				$(this).submit(); 
			})*/

			
			$('#addBtn').on('click', function(e){
				alert("에러 잇나?")
				e.preventDefault(); // 이것이 없으면 submit으로 넘어간다.
//				//alert("추가버튼 클릭")
//				
				let name = $('input[name=name]').val().trim(); //이름 가져와서 앞뒤 여백 제거
				if(name =='') {
					alert("이름을 입력하세요.");
					return false;
				}

				let yyyymmdd = $('input[name=yyyymmdd]').val().trim(); //이름 가져와서 앞뒤 여백 제거
				if(yyyymmdd =='') {
					alert("생년월일 입력하세요.");
					return false;
				}
				
				if (isNaN(yyyymmdd)){
					alert("숫자만 입력이 가능합니다.");
					return false; 
				}
				alert("체크포인트1");
				let email = $('input[name=email]').val().trim();
				alert("체크포인트2");
				let introduce = $('textarea[name=introduce]').val();	
				alert("체크포인트3");
				// AJAX: 폼태그와 상관없이 비동기로 별도 요청
				$.ajax({
					type: 'POST'
					, url: '/lesson06/ex01/add_user'
					, data: {"name":name, "yyyymmdd":yyyymmdd, "email":email, "introduce":introduce}
					, success: function(data) {	// AJAX 결과는 String이다.
						alert(data);
					}// 성공하면 (200) 여기에 들어온다.
					, complete: function(data){ 
						alert("완료");
						location.href = "/lesson06/ex01/afterAddUser";
						// location.reload();
					}// 실패하더라도 여기로 들어온다.
					, error: function(e) {
						alert("에러 " + e);
					}
				});
				
			});
		});
	</script>
	
</body>
</html>