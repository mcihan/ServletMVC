<%@page import="com.developera.model.Uyeler"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>

<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<style> <%@include file ="resources/css/style.css"%> </style>
<script charset="UTF-8"><%@include file="resources/js/script.js" %> </script>
</head>

<body>

	<form id="frm" method="post" action="UyelerController" onsubmit="return subResult();">

		<table border="1">
			<tr>
				<th>ID</th>
				<th>ADI</th>
				<th>SOYADI</th>
				<th>MESLEGI</th>
				<th>DOGUMYILI</th>
			</tr>
			<%
				List<Uyeler> uyeList = (List<Uyeler>) request.getAttribute("uyelist");
				if (uyeList != null)
					for (Uyeler u : uyeList) {
			%>
			<tr>
				<td><%=u.getUyeId()%></td>
				<td><%=u.getUyeAdi()%></td>
				<td><%=u.getUyeSoyadi()%></td>
				<td><%=u.getUyeMeslegi()%></td>
				<td><%=u.getUyeDogumYili()%></td>
				<td class="td_btn">
					<button style="background-color: #4CAF50" type="button"
						name="action" data-toggle="modal" data-target="#myModal"
						onclick="getRecord(this)">Guncelle</button>
				</td>
				<td class="td_btn" width="">
					<button style="background-color: #ff0000" onclick="submission('Sil');"
						name="action" value="sil-<%=u.getUyeId()%>">Sil</button>
				</td>
			</tr>
			<%
				}
			%>
			<tr>
				<td><input type="color" style="background-color: #dddddd"
					size="1" disabled="disabled" /></td>
				<td><input type="text" name="adi" size="10" /></td>
				<td><input type="text" name="soyadi" size="10" /></td>
				<td><input type="text" name="meslegi" size="10" /></td>
				<td><input type="text" name="dogumyili" size="10" /></td>
				<td class="td_btn"><button  name="action" value='Kaydet' onclick="submission('Kaydet')">Kaydet</button></td>
				<td class="td_btn"><button style="background: black" name="action" value='Temizle' 
											onclick="submission('Temizle')">Temizle</button></td>
						
			</tr>
		</table>

		<div class="container">

			<!-- Modal -->
			<div class="modal fade" id="myModal" role="dialog">
				<div class="modal-dialog">

					<!-- Modal content-->
					<div class="modal-content">
						<div class="modal-header">
							<h4 class="modal-title">Güncelle</h4>
						</div>
						<div class="modal-body">
							<table id="sss">
								<tr>
									<th><b>ID</b></th>
									<th><b>ADI</b></th>
									<th><b>SOYADI</b></th>
									<th><b>MESLEGI</b></th>
									<th><b>DOGUMYILI</b></th>
								</tr>
								<tr id="trGuncelle">
									<th><input type="text" name="mId" size="1" readOnly="readonly" /></th>
									<td><input type="text" name="mAdi" size="10" /></td>
									<td><input type="text" name="mSoyadi" size="10" /></td>
									<td><input type="text" name="mMeslegi" size="10" /></td>
									<td><input type="text" name="mDogumyili" size="10" /></td>
								</tr>
							</table>
						</div>
						<div class="modal-footer">
							<table>
								<tr>
									<td>
										<button type="submit" class="btn btn-default" name="action"
											value="Guncelle" onclick="submission('Guncelle')">Guncelle</button>
									</td>

									<td>
										<button type="button" class="btn btn-default"
											data-dismiss="modal">Kapat</button>
									</td>
								</tr>
							</table>

						</div>
					</div>

				</div>
			</div>

		</div>

	</form>
</body>
</html>
