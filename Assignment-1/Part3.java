
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
