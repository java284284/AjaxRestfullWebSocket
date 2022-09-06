<%@ page contentType="text/html; charset=UTF-8" %>
<html> 
<head>
<link rel='stylesheet' href='../css/styles.css'  type='text/css' />
<title>動態網頁</title>
</head>
<body BGCOLOR="white"> 
<jsp:include page="/commons/header.jsp" />
<h2 align="center">Ch09 Security</h2> 
<div align="center">
  
<table border="1">
  <tr height="52" bgcolor="lightblue" align="center">
    <td  width="400"><p align="left"/>
      <a href="_01_Memory_Realm/MemoryRealm.jsp">Memory Realm</a><BR>
           <font face="verdana" size="-2">  
           步驟一：在tomcat-users.xml內定義roles, users, passwords<br>
           步驟二：在context.xml(或server.xml)檔內定義&lt;Realm&gt;標籤<br>
           步驟三：在web.xml內定義受控管的資源<br>
           步驟四：存檔、重新啟動Tomcat、開始測試(john/mr123或mary/mr123)<br>
           步驟五：Digested Passwords, 修改&lt;Realm&gt;標籤<br>  
           步驟六：Digest版：在tomcat-users.xml內定義roles, users, passwords<br>
           步驟七：Digest版：存檔、重新啟動Tomcat、開始測試(john/mr456或mary/mr456)<br>
           </font>
    </td>
    <td  width="400"><p align="left"/>
       <a href="_02_JDBC_Realm/JDBCRealm.jsp">JDBC Realm</a><BR>
           <font face="verdana" size="-2">
           步驟一：在資料庫內定義roles, users, passwords(執行_Step01_createdb.sql)<br>
           步驟二：在context.xml(或server.xml內)檔內定義&lt;Realm&gt;標籤<br>
           步驟三：在web.xml內定義受控管的資源<br>
           步驟四：確認jdbc驅動程式已經在Tomcat的lib內<br>
           步驟五：存檔、重新啟動Tomcat、開始測試(john/jr123或mary/jr123)<br>
           步驟六：Digest版：修改&lt;Realm&gt;標籤<br>
           步驟七：Digest版：存檔、重新啟動Tomcat、開始測試(john2/jr456或mary2/jr456)<br>
           </font>
    </td>
  </tr>  
  <tr height="52" bgcolor="lightblue" align="center">
    <td  width="350"><p align="left"/>
      <a href="_03_DataSource_Realm/DataSourceRealm.jsp">DataSource Realm</a><BR>
            <font face="verdana" size="-2">
           步驟一：在資料庫內定義roles, users, passwords(執行createdb.sql)<br>
           步驟二：替資料庫建立一個能透過JNDI來存取的DataSource<br>
           步驟三：在context.xml(或server.xml內)檔內定義&lt;Realm&gt;標籤<br>
           步驟四：在web.xml內定義受控管的資源<br>
           步驟五：確認jdbc驅動程式已經在Tomcat的lib內<br>
           步驟六：存檔、重新啟動Tomcat、開始測試(john/dr123或mary/dr123)<br>
           步驟七：Digest版：修改&lt;Realm&gt;標籤<br>
           步驟八：Digest版：存檔、重新啟動Tomcat、開始測試(john2/dr456或mary2/dr456)<br>
           </font>
    </td>
    <td  width="350"><p align="left"/>
       <a href="_04_JAAS_Realm/JAASRealm.jsp">JAAS Realm</a><BR>
           <font face="verdana" size="-2"> 
           步驟一：在資料庫內定義roles, users, passwords(執行createdb.sql)<br>
           步驟二：沿用前面建立的&lt;resource&gt;所建立的DataSource<br>
           步驟三：在context.xml(或server.xml內)檔內定義&lt;Realm&gt;標籤<br>
           步驟四：在web.xml內定義受控管的資源<br>
           步驟五：確認jdbc驅動程式已經在Tomcat的lib內<br>
           步驟六：定義JAAS的組態設定檔 - jaas.config，此檔案將會放在%TOMCAT_HOME%/conf/資料夾下。<br>
           步驟七：於Tomcat runtime之下加入下列System property，告訴Tomcat runtime，
             JAAS的組態設定檔的位置。<br>
           步驟八：編寫程式<br>
           步驟九：存檔、重新啟動Tomcat、開始測試(john/ja123或mary/ja123)<br>
           </font>
           </font>
    </td>
  </tr>  
  
</table> 
</div>
<hr>
<jsp:include page="/commons/footer.jsp" />
</body>
</html>
