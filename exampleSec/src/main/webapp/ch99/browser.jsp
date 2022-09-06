<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel='stylesheet' href='../css/styles.css'  type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>瀏覽器如何提出請求</title>
</head>
<body>
<center>
<h2>瀏覽器如何提出請求</h2>
</center>
<pre>
在HTML文件(它本身就是一個網路資源)內表示某一個網路資源有兩種方法：
「絕對路徑」與「相對路徑」。

所謂「絕對路徑」就是用網路資源的完整URL來表示，例如：
http://www.iiiedu.org.tw/taipei/edm/eeit.htm
絕對路徑包含『通訊協定』、『主機名稱(或IP)』、『資源在主機內的路徑』
與『資源的名稱』。在HTML文件內要表示位於不同主機的網路資源就必須使用
絕對路徑。

所謂「相對路徑」就是相對於『本HTML文件所在主機』的表示法，在HTML
文件內要表示位於相同主機的網路資源就應該使用相對路徑。

相對路徑又可細分為(1)相對於文件根目錄與(2)相對於本文件所在目錄兩種：
(1)相對於文件根目錄:    /example/images/snoopy.jpg  (以/開頭的字串)
(2)相對於本文件所在目錄: kitty.jpg                   (不是以/開頭的字串)

相對「本文件所在目錄」所指到的網路資源，會隨著本文件所在目錄的不同而改變。

假設現在網站localhsot內的架構如下：

-文件根目錄(webapps)
  |
  |- jspExercise
  |  ...
  |- examples
  |   |- ch01
  |   |   ...
  |   |- ch02
  |   |	   |- request
  |   |    | ...
  |   |    | index.jsp
  |   |- ch03
  |   |- ...  	  
  |   |- ...  
  |   |- ch99
  |   |    | index.html
  |   |    | kitty.jpg
  |   |- images
  |   |    | snoopy.jpg
  |  	   
  |- servers 　

  
瀏覽器如何提出請求：
當使用者按下『超連結』、使用者按下Form表單內的『提交』按鈕或當瀏覽器遇到
&lt;img src="..." &gt;標籤而需要向伺服器提出請求、要求某項資源時，如果該
項資源在網頁內是以相對路徑表示，瀏覽器會參考本網頁的URL來補足相對路徑所缺
少的資訊，例如:
(1)通訊協定
(2)伺服器名稱或IP
(3)資源在主機內的路徑

補足缺少的資訊後，瀏覽器就會送出請求。
</pre>
<jsp:include page="/commons/previousPage.jsp" />
</body>
</html>