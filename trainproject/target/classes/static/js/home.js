function cl()
{
    var cl = document.getElementById("cl").value;
    var quota = document.getElementById("quota").value;
    var amount = document.getElementById("ticketPrice").innerText;
    amount = parseInt(amount);
    var amount1;

    if(cl=="ac2" && quota=="general")
    {
        amount1 = (amount + (amount*2.8));
        console.log(amount1);
    }
    else if(cl=="ac2" && quota=="ladies")
    {
        amount1 = (amount + (amount*2.8)) - (amount*0.1);

        console.log(amount1);
    }
    else if(cl=="ac2" && quota=="senior")
    {
        amount1 = (amount + (amount*2.8))- (amount*0.2);
        console.log(amount1);
    }
    else if(cl=="ac2" && quota=="tatkal")
    {
        amount1 = (amount + (amount*2.8)) + (amount*0.05);
        console.log(amount1);
    }


    else if(cl=="ac3" && quota=="general")
    {
        amount1 = (amount + (amount*1.5));
        console.log(amount1);
    }
    else if(cl=="ac3" && quota=="ladies")
    {
        amount1 = (amount + (amount*1.5))- (amount*0.1);
        console.log(amount1);
    }
    else if(cl=="ac3" && quota=="senior")
    {
        amount1 = (amount + (amount*1.5)) - (amount*0.2);
        console.log(amount1);
    }
    else if(cl=="ac3" && quota=="tatkal")
    {
        amount1 = (amount + (amount*1.5)) + (amount*0.05);
        console.log(amount1);
    }

  
    else if(cl=="chair" && quota=="general")
    {
        amount1 = (amount - (amount*0.3));
        console.log(amount1);
    }
    else if(cl=="chair" && quota=="ladies")
    {
        amount1 = (amount - (amount*0.3)) - (amount*0.1);
        console.log(amount1);
    }
    else if(cl=="chair" && quota=="senior")
    {
        amount1 = (amount - (amount*0.3)) - (amount*0.2);
        console.log(amount1);
    }
    else if(cl=="chair" && quota=="tatkal")
    {
        amount1 = (amount - (amount*0.3)) + (amount*0.05);
        console.log(amount1);
    }


    else if(cl=="sl" && quota=="ladies")
    {
        amount1 = amount - (amount*0.1);
        console.log(amount1);
    }
    else if(cl=="sl" && quota=="senior")
    {
        amount1 = amount - (amount*0.2);
        console.log(amount1);
    }
    else if(cl=="sl" && quota=="tatkal")
    {
        amount1 = amount + (amount*0.05)
        console.log(amount1);
       
    }
    else
    {
        amount1 = amount
        console.log(amount1);
    }
    
}