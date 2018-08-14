cf push data-sample-app -p ...
cf create-service cleardb spark data-sample-db
cf bind-service data-sample-app data-sample-db
cf cups remote-sample-db -p '{"uri":"mysql://root:welcome1@ec2-18-216-93-73.us-east-2.compute.amazonaws.com/test?&useSSL=false"}'