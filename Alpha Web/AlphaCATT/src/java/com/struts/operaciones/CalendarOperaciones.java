package com.struts.operaciones;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.myapp.hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.myapp.model.Calendario;
import com.myapp.dao.CalendarioDao;

import com.myapp.model.Sala;
import com.myapp.dao.SalaDao;
import com.myapp.bs.SalaBs;

import com.myapp.bs.TTBs;

import com.myapp.model.Dirige;
import com.myapp.dao.DirigeDao;

import com.myapp.model.Sinodalia;




public class CalendarOperaciones 
{

  public List<Calendario> getCalendar()
    {         
          CalendarioDao calendarioDao = new CalendarioDao();
          List<Calendario> calendario = calendarioDao.findAll();
          for(int i = 0; i < calendario.size(); i++)
          {
              calendario.get(i).setSala(SalaBs.findById(calendario.get(i).getSala().getIdSala()));
              calendario.get(i).setTt(TTBs.findById(calendario.get(i).getTt().getIdTt()));    
          }

          return calendario;
    }
  
  
          
}
