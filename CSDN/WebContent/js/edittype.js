//点击出现类别修改框
function edit(obj)
{
	var i1=obj.id+1;
	var i2=obj.id+2;
	if(document.getElementById(i1).style.display=='none'&&document.getElementById(i2).style.display=='block')
	{
		document.getElementById(i1).style.display='block';
	 	document.getElementById(i2).style.display='none';
	}else
	{
		document.getElementById(i1).style.display='none';
	 	document.getElementById(i2).style.display='block';
	}
}
//点击“原创”时，出现提示文章
function change()
{
	var objS=document.getElementById("TypeSel");
	var id=objS.options[objS.selectedIndex].id;
	if(id==1){
		document.getElementById("message").style.display='inline-block';
	}else{
		document.getElementById("message").style.display='none';
	}
}
//在文本框加入所勾选的内容
function addmytype(obj)
{
	var node=document.getElementById("newmtype");
	var old=node.value;
	var add=obj.nextSibling.nodeValue;
	
	if(old!=""){
		var n=old+","+add;
		document.getElementById("newmtype").value=n;
	}else{
		var n=add;
		document.getElementById("newmtype").value=n;
	}
	
}
//条件查询
function conditionFind(obj)
{
	document.getElementById("form1").submit();
}

function reply(obj)
{
	if(document.getElementById(obj).style.display=='none')
	{
		document.getElementById(obj).style.display='block';
	}else
	{
		document.getElementById(obj).style.display='none';
	}
}
