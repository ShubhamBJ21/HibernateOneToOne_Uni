# One-To-One uni directional Mapping

For acheiving this we need one annotation called as @OneToOne. Here, we will create refrence variable of one class in an another class, that will be annoted with '@OneToOne'. 
By considering this annotations hibernate will create a foreign key inside owning side. 
Here two tables will be generated, one is for owning side(Person) and another one is for non-owning side(AdharCard).
