   function mem_check(){
      if(document.join_frm.id.value.length ==0){
         window.alert("Insert ID");
         join_frm.id.focus();
         return;
      }
      if(document.join_frm.id.value.length < 4){
         window.alert("ID must be more than 4.....");
         join_frm.id.focus();
         return;
      }
      if(document.join_frm.passwd.value.length ==0){
         window.alert("Insert Password");
         join_frm.passwd.focus();
         return;
      }
      if(document.join_frm.passwd.value != document.join_frm.passwd_chk.value){
         window.alert("Check the Password");
         join_frm.passwd_chk.focus();
         return;
      }
      document.join_frm.submit();
   }
   
   function updateInfo(){
      if(document.modify_frm.passwd.value.length ==0){
         window.alert("Insert Password");
         join_frm.passwd.focus();
         return;
      }
      if(document.modify_frm.passwd.value != document.modify_frm.passwd_chk.value){
         window.alert("Check the Password");
         document.modify_frm.passwd.focus();
         return;
      }
      document.modify_frm.submit();
   }