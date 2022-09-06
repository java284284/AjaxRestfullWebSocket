rem 執行此批次檔後，會在本目錄下產生四個檔案。若要重新執行本批次檔必須先刪除這四個檔案。
rem 產生Server的金鑰儲存庫(Keystores): server.jks
keytool -genkeypair -alias tomcat -keyalg RSA -dname "CN=192.168.11.62,OU=Application Development,O=Kitty Company,L=KittyCity,S=LD,C=UK" -keypass password -keystore server.jks -storepass password

rem 產生Client的金鑰儲存庫(Keystores): client.jks
keytool -genkeypair -alias clientkey -keyalg RSA -dname "CN=client,OU=Application Development,O=Kitty Company,L=KittyCity,S=LD,C=UK" -keypass password -storepass password -keystore client.jks

rem 匯出Client的公鑰(client-public.cer)，並放入Server的金鑰儲存庫(server.jks): 
keytool -exportcert -alias clientkey -file client-public.cer -keystore client.jks -storepass password
keytool -importcert -keystore server.jks -alias clientcert -file client-public.cer -storepass password -noprompt

rem 檢視Server的金鑰儲存庫
keytool -list -keystore server.jks -storepass password

rem 匯出Server的公鑰(server-public.cer)，並放入Client的金鑰儲存庫(client.jks): 
keytool -exportcert -alias tomcat -file server-public.cer -keystore server.jks -storepass password
keytool -importcert -keystore client.jks -alias servercert -file server-public.cer -storepass password -noprompt

rem 檢視Client的金鑰儲存庫
keytool -list -keystore client.jks -storepass password
