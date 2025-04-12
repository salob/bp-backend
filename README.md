# bp-backend


docker run -d -p 27017:27017 --name local-mongo mongo  

docker exec -it local-mongo mongosh --eval "use bpdb; db.bptips.find().pretty()"

curl -X POST http://localhost:8080/bptip \
  -H "Content-Type: application/json" \
  -d '{"category": "High", "tip": "Reduce salt intake"}'

curl -X GET http://localhost:8080/bptip?category=High

docker exec -it local-mongo mongosh --eval "show dbs"


docker exec -i local-mongo mongosh <<EOF
use bpdb
db.bp_tips.find().pretty()
EOF