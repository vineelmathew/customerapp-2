export class Customer{
  id:number;
    name:string;
    balance:number;

    constructor(name:string,balance:number){
        this.name=name;
        this.balance=balance;
    }

    getName():string{
        return this.name;
      }
    
      getSalary():number{
        return this.balance;
      }
    
}