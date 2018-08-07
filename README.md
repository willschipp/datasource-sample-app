cf push data-sample-app -p ...
cf create-service cleardb spark data-sample-db
cf bind-service data-sample-app data-sample-db
cf cups remote-sample-db -p '{"uri":"mysql://root:password1@18.222.163.238/testdb?&useSSL=false"}'