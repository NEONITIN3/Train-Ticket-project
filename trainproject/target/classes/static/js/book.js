function aclear()
		{
			document.getElementById("inp").reset(); 
		}

function passData()
{
	var number = document.getElementById("noPassenger").value;
	for (i=1;i<=number;i++)
	{
		var Name = document.getElementById("name"+i).value;
		var Age = document.getElementById("age"+i).value;
		var Gender = document.getElementById("gender"+i).value;

		localStorage["Name"+i]=Name;
		localStorage["Age"+i]=Age;
		localStorage["Gender"+i]=Gender;
	}
}


function addPassenger()
{
	var number = document.getElementById("noPassenger").value;
	var container = document.getElementById("container1");
	var amount = document.getElementById("price").value;
	var total = number*amount;
	localStorage["total"]=total;
	localStorage["number"]=number;
	localStorage["amount"]=amount;
	document.getElementById("getPrice").innerHTML = "₹ "+ total;

	while (container.hasChildNodes()) {
        container.removeChild(container.lastChild);
    }
		for (i=1;i<=number;i++)
		{
		// var container = document.createElement('div');
		// container.id = 'container'; 
        container.appendChild(document.createTextNode("Name: "));
        var Name = document.createElement("input");
        Name.type = "text";
		Name.id = "name"+i;
		Name.name="name";
		Name.setAttribute("class","form-control");
		Name.style="margin-right: 6.7%; margin-left: 2px;";
		Name.setAttribute("required","");
        container.appendChild(Name);
        // container.appendChild(document.createElement("br"));
		container.appendChild(document.createTextNode("Age: "));
        var Age = document.createElement("input");
        Age.type = "number";
		Age.id = "age"+i;
		Age.name="age";
		Age.max="100";
		Age.min="6";
		Age.setAttribute("required","");
		Age.setAttribute("class","form-control");
		Age.style="margin-right: 6%; margin-left: 2px;";
        container.appendChild(Age);
		container.appendChild(document.createTextNode("Gender: "));
		var male = document.createElement("input");
		male.type="radio";
		male.id="gender"+i;
		male.name="gender"+i;
		male.value="M";
		male.setAttribute("required","")
		container.appendChild(male);
		container.appendChild(document.createTextNode("Male "));
		
		var female = document.createElement("input");
		female.type="radio";
		female.id="gender"+i;
		female.name="gender"+i;
		female.value="F";
		female.setAttribute("required","")
		container.appendChild(female);
		container.appendChild(document.createTextNode("Female "));

		container.appendChild(document.createElement("br"));
    }
	// container1.appendChild(container);
}
	

const paymentStart = () =>{
	console.log("payment started..");
	var amount = document.getElementById("price").value;
	var count = document.getElementById("noPassenger").value;
	var total = amount * count;
	document.getElementById("getPrice").innerHTML = total;
	console.log(total);

	if(total=='' || total==null)
	{
		// alert("amount is required !!")
		swal("Failed !!", "amount is required !!", "error");
		return;
	}

	$.ajax({
			url:'/user/create_order',
			data:JSON.stringify({total:total,info:'order_request'}),
			contentType:'application/json',
			type:'POST',
			dataType:'json',
			success:function(response)
			{
				//invoke when success
				console.log(response);
				if(response.status == "created")
				{
					// open payment form
					let options={
						key:'rzp_test_qYNLQWU7Ez6Kxq',
						amount:response.amount,
						currency:'INR',
						name:'Train Reservation',
						image:'https://cdn.dribbble.com/users/293562/screenshots/4595457/railroaders-dribbble.jpg?compress=1&resize=800x800',											
						description:'ticket price',
						order_id:response.id,
						handler:function(response) {
							console.log(response.razorpay_payment_id);
							console.log(response.razorpay_order_id);
							console.log(response.razorpay_signature);
							console.log("payment successful");
							swal("₹ " + total, "congrats !! payment successful !!", "success");
						},
						prefill: {
							name: "",
							email: "",
							contact: ""
						},
						notes: {
							address: "THBS Team_01",
						},
						theme: {
							color: "#2196F3",
							// #3399cc
							// 5093f8
							// ptm  24b8f3
							// phonpay 6a33cf
						},					
					};

					let rzp = new Razorpay(options);
					rzp.on('payment.failed', function (response)
					{
						console.log(response.error.code);
						console.log(response.error.description);
						console.log(response.error.source);
						console.log(response.error.step);
						console.log(response.error.reason);
						console.log(response.error.metadata.order_id);
						console.log(response.error.metadata.payment_id);
						alert("Oops payment failed !!");
						swal("Failed !!", "Oops payment failed !!", "error");
					});
					rzp.open();
				}
			},

			error:function(error)
			{
				console.log(error);
				alert("Something went wrong !!")
			}

		}
	)

};