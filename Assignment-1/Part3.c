
/*    STACKS  IMPLEMENTATION    */
#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <stdbool.h>

typedef struct nodeStruct{
    int value;
    struct nodeStruct *nextPtr;
}Node;

typedef struct linkedlist{
    Node *head, *tail;
}NodeList;

NodeList* initStack();
void pushStack(NodeList*,int);
void popStack(NodeList*);
void printList(NodeList*);
Node* top(NodeList*);
bool isEmpty(NodeList*);
int size(NodeList*);

bool isEmpty(NodeList* p){
  if(p==NULL){
    return true;
  }
  return false;
}

int size(NodeList* p){
  int count = 0;
  Node *temp;
  temp=p->head;

  while(temp!=NULL)
  {
	  count++;
	  temp=temp->nextPtr;
  }
  //If stack is empty it returns 0
  return count;
}

NodeList* initStack()
{
   NodeList* p;
   p=(NodeList*)malloc(sizeof(NodeList));
   if(p==NULL)//If malloc fails an error message is printed out.
   {
	   printf("Malloc failed./n");
   }
   p->head=NULL;
   p->tail=NULL;
   return p;
}

void pushStack(NodeList* p,int k)
{
	Node *newNode, *temp;
	newNode =(Node*)malloc(sizeof(Node));
    if(newNode==NULL)//If malloc fails an error message is printed out.
    {
	   printf("Malloc failed./n");
    }
	newNode->value=k;
	temp=p->head;
	if(temp==NULL)
	{
		p->tail=newNode;
	}
	newNode->nextPtr=temp;
	p->head = newNode;
}

void popStack(NodeList* p)
{
	  Node *temp;
	  temp = p->head;
	  if(temp==NULL)
	  {
	    //printf("The current stack is empty.\n");
	  }
	  //The pointer to a struct, Hold, stores the node to be popped.
	  Node *hold;
	  hold=(Node*)malloc(sizeof(Node));
    if(hold==NULL)
	  {
	  	printf("Malloc failed.\n");//Error checking
	  }
  	hold->value=temp->value;
	  hold->nextPtr=temp->nextPtr;
	  //The pointer to a struct, temp, is moved to the next node.
	  temp=temp->nextPtr;
	  p->head=temp;
	
}

Node* top(NodeList* p){
  	Node *temp;
	  temp=p->head;
	  if(temp==NULL)
	  {
	    printf("The current stack is empty.\n");
	    return NULL;//No struct can be popped 
	  }
	//The pointer to a struct, Hold, stores the node to be popped.
	  Node *hold;
	  hold=(Node*)malloc(sizeof(Node));
    if(hold==NULL)
	  {
	  	printf("Malloc failed.\n");//Error checking
	  }
  	hold->value=temp->value;
	  hold->nextPtr=temp->nextPtr;

    return hold;
}


/*   QUEUE  IMPLEMENTATION    */

NodeList* initQueue();
void enQueue(NodeList*,int);
void deQueue(NodeList*);
Node* rear(NodeList*);
Node* front(NodeList*);
bool isEmpty(NodeList*);
int size(NodeList*);
void freeList(NodeList*);
NodeList* initQueue()
{
   NodeList* p;
   p=(NodeList*)malloc(sizeof(NodeList));
   if(p==NULL)//If malloc fails an error message is printed out.
   {
	   printf("Malloc failed./n");
   }
   p->head=NULL;
   p->tail=NULL;
   return p;
}

bool isEmpty(NodeList* p){
  if(p==NULL){
    return true;
  }
  return false;
}

int size(NodeList* p){
  int count = 0;
  Node *temp;
  temp=p->head;

  while(temp!=NULL)
  {
	  count++;
	  temp=temp->nextPtr;
  }
  //If stack is empty it returns 0
  return count;
}

void enQueue(NodeList* p,int k)
{
   Node *newNode; 
   newNode=(Node*)malloc(sizeof(Node));
   if(newNode==NULL)//insertion failed
   {
      printf("Malloc failed.\n");
	  
   }
   newNode->value=k;
   Node *temp;
   temp=p->head;
   if(temp==NULL)
   {
	  //new->nextPtr=NULL;
	 // p->head=new;
	  p->tail=newNode;
   }
   newNode->nextPtr=temp;
   p->head=newNode;
}

void deQueue(NodeList* p)
{
	Node *newNode; 
	newNode=p->head;
	if(newNode==NULL)
	{
		printf("No struct can be dequeued.\n");
	}
	while(newNode->nextPtr->nextPtr!=NULL)
	{
		newNode=newNode->nextPtr;//moves to the next node
	}
	newNode->nextPtr=NULL;
	Node *temp;
	temp=p->tail;
	p->tail=newNode;
}

Node* rear(NodeList* p){
  	Node *temp;
	  temp=p->tail;
	  if(temp==NULL)
	  {
	    printf("The current stack is empty.\n");
	    return NULL;//No struct can be popped 
	  }
	//The pointer to a struct, Hold, stores the node to be popped.
	  Node *hold;
	  hold=(Node*)malloc(sizeof(Node));
    if(hold==NULL)
	  {
	  	printf("Malloc failed.\n");//Error checking
	  }
  	hold->value=temp->value;
	  hold->nextPtr=temp->nextPtr;

    return hold;
}


Node* front(NodeList* p){
  	Node *temp;
	  temp=p->head;
	  if(temp==NULL)
	  {
	    printf("The current stack is empty.\n");
	    return NULL;//No struct can be popped 
	  }
	//The pointer to a struct, Hold, stores the node to be popped.
	  Node *hold;
	  hold=(Node*)malloc(sizeof(Node));
    if(hold==NULL)
	  {
	  	printf("Malloc failed.\n");//Error checking
	  }
  	hold->value=temp->value;
	  hold->nextPtr=temp->nextPtr;

    return hold;
}

bool isEmpty(NodeList* p){
  if(p==NULL){
    return true;
  }
  return false;
}

int size(NodeList* p){
  int count = 0;
  Node *temp;
  temp=p->head;

  while(temp!=NULL)
  {
	  count++;
	  temp=temp->nextPtr;
  }
  //If stack is empty it returns 0
  return count;
}


void freeList(NodeList* p)
{
	Node *temp, *hold;
	temp=p->head;
	free(p);
	p=NULL;
	while(temp!=NULL)
	{
		hold=temp->nextPtr;//points to the next node.
		free(temp);
		temp=NULL;
		temp=hold;
	}	
}
