 function getRecord(btn) {

	var trKayit = btn.parentNode.parentNode.cells;
	var deger = trKayit[0].innerHTML;

	var r = document.getElementById("trGuncelle").cells;

	for (var i = 0; i < 5; i++) {
		r[i].childNodes[0].value = trKayit[i].innerHTML;
	}
}
 
var sub =false;
function submission(value) 
{
	var mesaj = "";
	if (value == "Sil")
	{
		sub = confirm("Bu Kaydi Silmek Istediginizden Emin misiniz ?");
	} 
	else if (value == "Temizle") {
		sub = confirm("Butun Kayitlari Silmek Istediginizden Emin misiniz ?");
	}
	else
	{	 
		sub = true;
	}
	
}
function subResult() 
{
	return sub;
}

 