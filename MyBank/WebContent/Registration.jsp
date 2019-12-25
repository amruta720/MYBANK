<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.*"%>
    <%@page import="javax.mail.*"%>
    <%@page import="javax.mail.internet.*" %>
        
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<%	
	String result;
	final String to=request.getParameter("mail");
	final String subject=request.getParameter("sub");
	final String messg=request.getParameter("mess");
	final String from="amrutak7200@gmail.com";
	final String pass="ammu@1234";
	String host="smtp.gmail.com";
	Properties props=new Properties();
	props.put("mail.smtp.host",host);
	props.put("mail.transport.protocol","smtp");
	props.put("mail.smtp.debug","true");
	props.put("mail.smtp.auth","true");
	props.put("mail.smtp.socketFactory.port","465");	
	props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
	props.put("mail.smtp.socketFactory.fallback","false");	

	props.put("mail.smtp.starttls.enable","true");
	props.put("mail.user",from);
	props.put("mail.password",pass);

	props.put("mail.smtp.ssl.trust","smtp.gmail.com");

	props.put("mail.port","465");	
	Session mailSession=Session.getInstance(props,new javax.mail.Authenticator(){
		@Override
	protected PasswordAuthentication getPasswordAuthentication(){
			return new PasswordAuthentication(from,pass);
					}
	}
	);
	try
	{
		MimeMessage message=new MimeMessage(mailSession);
		message.setFrom(new InternetAddress(from));
		message.setRecipients(Message.RecipientType.TO,
				 InternetAddress.parse(to));
		message.setSubject(subject);
		message.setText(messg);
		Transport.send(message);
		result="Success.jsp";
	}
	catch(MessagingException mex)
	{
		mex.printStackTrace();
		result="Error:unable to send message......";
		
	}
	
	%>>
	
</body>
</html>