var frm = document.join_frm;
	function mem_check(){
		if(document.join_frm.id.value.length == 0){
			alert("아이디를 입력해 주세요!");
			join_frm.id.focus();
			return; //밑에 로직 수행하지 않게
		}
		
		if(document.join_frm.id.value.length < 10){
			alert("아이디는 최소 10자 이상이어야 합니다.");
			join_frm.id.focus();
			return; //밑에 로직 수행하지 않게
		}
		
		if(document.join_frm.passwd.value.length == 0){
			alert("비밀번호를 입력해 주세요!");
			join_frm.id.focus();
			return; //밑에 로직 수행하지 않게
		}
		
		if(document.join_frm.passwd.value != document.join_frm.passwd.value){
			alert("비밀번호가 일치하지 않습니다!");
			join_frm.id.focus();
			return; //밑에 로직 수행하지 않게
		}
		
		document.join_frm.submit();
	}