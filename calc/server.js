const express=require("express");
const bodyParser=require("body-parser");

const app=express();
app.use(bodyParser.urlencoded({extended: true}));

app.get("/",function(req,res)
{
res.sendFile(__dirname + "/index.html"); 
})
app.listen(8080,function(){
	console.log("Server is working on port 8080");
}) 
app.post("/",function(req,res)
{
	var r=Number(req.body.num1)+Number(req.body.num2);

	res.send("Result is "+r);
})