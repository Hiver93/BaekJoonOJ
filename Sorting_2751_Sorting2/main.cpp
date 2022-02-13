// 실패한 트리정렬
//#include <iostream>
//#include <vector>
//#include <stack>
//using namespace std;
//
//class Node
//{
//public:
//	Node* bigger;
//	Node* smaller;
//	Node* parent = nullptr;
//	int data;
//	Node(int i)
//	{
//		data = i;
//	}
//};
//
//int main()
//{
//	int n;
//	cin >> n;
//	vector<int> vec(n);
//	stack<Node*> pStack;
//
//	for (int i = 0; i < n; i++)
//	{
//		cin >> vec[i];
//	}	
//	Node* tree = new Node(vec[0]);
//	Node* temp = tree;
//	for (int i = 1; i < n; i++)
//	{
//		while (1)
//		{
//			if (temp->data < vec[i])
//			{
//				if (temp->bigger == nullptr)
//				{
//					temp->bigger = new Node(vec[i]);
//					temp->bigger->parent = temp;
//					break;
//				}
//				temp = temp->bigger;
//			}
//			else
//			{
//				if (temp->smaller == nullptr)
//				{
//					temp->smaller = new Node(vec[i]);
//					temp->smaller->parent = temp;
//					break;
//				}
//				temp = temp->smaller;
//			}
//		}
//		temp = tree;
//	}
//
//	while (1)
//	{
//		if (temp->smaller != nullptr)
//		{
//			pStack.push(temp);
//			temp = temp->smaller;
//		}
//		else
//		{
//			while (1)
//			{
//				printf("%d\n",temp->data);
//				if (temp->bigger != nullptr)
//				{
//					temp = temp->bigger;
//					break;
//				}
//				else
//				{
//					if (!pStack.empty())
//					{
//						temp = pStack.top();
//						pStack.pop();
//					}
//					else
//						return 0;
//				}
//			}
//		}
//	}	
//
//	return 0;
//}