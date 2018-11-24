package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import java.util.ArrayList;
import javax.servlet.ServletContext;

/**
 * Application Lifecycle Listener implementation class OnLineListener
 *
 */
@WebListener
public class OnLineListener implements ServletContextListener, HttpSessionListener, HttpSessionAttributeListener, HttpSessionBindingListener 
{
	private ServletContext application = null;

    /**
     * Default constructor. 
     */
    public OnLineListener() 
    {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent httpSessionEvent)  
    { 
         // TODO Auto-generated method stub
    }

	/**
     * @see HttpSessionBindingListener#valueBound(HttpSessionBindingEvent)
     */
    public void valueBound(HttpSessionBindingEvent httpSessionBindingEvent)  
    { 
         // TODO Auto-generated method stub
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent)  
    { 
    	System.out.println("==========sessionDestroyed==========");
		ArrayList online = (ArrayList) application.getAttribute("online");//ȡ���û����б�
		String username = (String) httpSessionEvent.getSession().getAttribute("username");//ȡ�õ�ǰ�û���	
		online.remove(username);//�����û������б���ɾ��	
		this.application.setAttribute("online", online);//��ɾ������б��������õ�application������
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent servletContextEvent)  
    { 
         // TODO Auto-generated method stub
    }

	/**
     * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
     */
    public void attributeAdded(HttpSessionBindingEvent httpSessionBindingEvent)  
    { 
    	System.out.println("==========attributeAdded==========");
    	ArrayList online = (ArrayList) application.getAttribute("online");//ȡ���û����б� 
    	String attrName = (String)httpSessionBindingEvent.getName();
    	String attrValue = (String)httpSessionBindingEvent.getValue();
    	online.add(attrValue);//����ǰ�û�����ӵ��б��� 	
    	this.application.setAttribute("online", online);//����Ӻ���б��������õ�application����
    }

	/**
     * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
     */
    public void attributeRemoved(HttpSessionBindingEvent httpSessionBindingEvent)  
    { 
    	System.out.println("==========attributeRemoved==========");
    }

	/**
     * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
     */
    public void attributeReplaced(HttpSessionBindingEvent httpSessionBindingEvent)  
    { 
    	System.out.println("==========attributeReplaced==========");
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent servletContextEvent)  
    { 
    	System.out.println("==========contextInitialized==========");
    	this.application = servletContextEvent.getServletContext();	//��ʼ��һ��application����	
    	this.application.setAttribute("online", new ArrayList());//����һ��ArrayList�������ڱ��������û���
    }

	/**
     * @see HttpSessionBindingListener#valueUnbound(HttpSessionBindingEvent)
     */
    public void valueUnbound(HttpSessionBindingEvent httpSessionBindingEvent)  
    { 

    }
	
}
