rem ���榹�妸�ɫ�A�|�b���ؿ��U���ͥ|���ɮסC�Y�n���s���楻�妸�ɥ������R���o�|���ɮסC
rem ����Server�����_�x�s�w(Keystores): server.jks
keytool -genkeypair -alias tomcat -keyalg RSA -dname "CN=192.168.11.62,OU=Application Development,O=Kitty Company,L=KittyCity,S=LD,C=UK" -keypass password -keystore server.jks -storepass password

rem ����Client�����_�x�s�w(Keystores): client.jks
keytool -genkeypair -alias clientkey -keyalg RSA -dname "CN=client,OU=Application Development,O=Kitty Company,L=KittyCity,S=LD,C=UK" -keypass password -storepass password -keystore client.jks

rem �ץXClient�����_(client-public.cer)�A�é�JServer�����_�x�s�w(server.jks): 
keytool -exportcert -alias clientkey -file client-public.cer -keystore client.jks -storepass password
keytool -importcert -keystore server.jks -alias clientcert -file client-public.cer -storepass password -noprompt

rem �˵�Server�����_�x�s�w
keytool -list -keystore server.jks -storepass password

rem �ץXServer�����_(server-public.cer)�A�é�JClient�����_�x�s�w(client.jks): 
keytool -exportcert -alias tomcat -file server-public.cer -keystore server.jks -storepass password
keytool -importcert -keystore client.jks -alias servercert -file server-public.cer -storepass password -noprompt

rem �˵�Client�����_�x�s�w
keytool -list -keystore client.jks -storepass password
