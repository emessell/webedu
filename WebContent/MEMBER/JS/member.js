   function mem_check() {
      if (document.join_frm.id.value.length == 0) {
         window.alert("���̵� �Է����ּ���.");
         document.join_frm.id.focus();
         return;
      }
      if (document.join_frm.id.value.length < 4) {
         window.alert("���̵� 4�� �̻� �Է����ּ���.");
         document.join_frm.id.focus();
         return;
      }
      if (document.join_frm.passwd.value.length == 0) {
         window.alert("��й�ȣ�� �Է����ּ���.");
         document.join_frm.passwd.focus();
         return;
      }
      if (document.join_frm.passwd.value != document.join_frm.passwd_chk.value) {
         window.alert("��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
         document.join_frm.passwd_chk.focus();
         return;
      }
      document.join_frm.submit();
   }
   