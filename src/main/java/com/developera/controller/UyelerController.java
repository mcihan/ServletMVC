package com.developera.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.developera.dao.UyelerDAO;
import com.developera.model.Uyeler;
 
public class UyelerController extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		 response.setContentType("text/html");
		 response.setCharacterEncoding("UTF-8");
		 
		 dataRecord(request,response);
	 } 
	 
	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		dataRecord(request,response);
		
	} 
	
	private void dataRecord(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
	{
		UyelerDAO uyelerDao =  new UyelerDAO();
		uyelerDao.openCurrentSessionwithTransaction();
		
		String id ,adi,soyadi,meslegi,dogumyili,button ;
		id = adi = soyadi = meslegi = dogumyili = button = "";
		
		if(request.getParameterMap().size() > 0)
		{
			id = request.getParameter("id");  
			adi = request.getParameter("adi");  
			soyadi = request.getParameter("soyadi");  
			meslegi = request.getParameter("meslegi");  
			dogumyili = request.getParameter("dogumyili");  
			button = request.getParameter("action");
			
		} 
		
		if(button.equals("Kaydet"))
		{
			Uyeler uye = new Uyeler();
			uye.setUyeAdi(adi);
			uye.setUyeSoyadi(soyadi);
			uye.setUyeMeslegi(meslegi);
			uye.setUyeDogumYili(dogumyili);
			uyelerDao.insert(uye);

		}
		else if (button.equals("Guncelle"))
		{
			
			id = request.getParameter("mId");  
			adi = request.getParameter("mAdi");  
			soyadi = request.getParameter("mSoyadi");  
			meslegi = request.getParameter("mMeslegi");  
			dogumyili = request.getParameter("mDogumyili");
			
			Uyeler uye = uyelerDao.findById(id);
			uye.setUyeId(Integer.parseInt(id));
			uye.setUyeAdi(adi);
			uye.setUyeSoyadi(soyadi);
			uye.setUyeMeslegi(meslegi);
			uye.setUyeDogumYili(dogumyili);
			uyelerDao.update(uye); 
		} 
		else if (button.equals("Temizle"))
		{
			uyelerDao.deleteAll();
		}
		 
		if(button.contains("sil-"))
		{
			id = button.replace("sil-", "").trim();
			Uyeler uye = uyelerDao.findById(id);
			uyelerDao.delete(uye);
		}
		
		uyelerDao.commit();
		 
		List<Uyeler> uyeList = uyelerDao.findAll();
		uyelerDao.closeCurrentSession();
		
		request.setAttribute("uyelist", uyeList);
	    RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response); 
		 
	}
}
