import re

def solution(new_id):
    answer = new_id
    answer = answer.lower()
    answer = re.sub('[^a-z0-9\-_.]', '', answer)
    answer = re.sub('\.+', '.', answer)
    answer = re.sub('^[.]|[.]$', '', answer)
    answer = 'a' if len(answer) == 0 else answer[:15]
    answer = re.sub('^[.]|[.]$', '', answer)
    answer = answer if len(answer) > 2 else answer + "".join([answer[-1] for i in range(3-len(answer))])
    return answer

# def solution(new_id):
#     answer = ''
#     new_answer = ''
    
#     new_id = new_id.lower()
    
#     for s in new_id:
#         if s.isdigit() or s.islower() or s == '-' or s == '_' or s == '.':
#             new_answer += s
    
#     dot = False
#     for i in range(len(new_answer)):
#         if new_answer[i] == '.' and dot == False:
#             answer += new_answer[i]
#             dot = True
#         elif new_answer[i] != '.':
#             answer += new_answer[i]
#             dot = False
        
#     while len(answer) > 0 and answer[0] == '.' :
#         if answer == '.':
#             answer = ''
#         else:
#             answer = answer[1:]
            
#     while len(answer) > 0 and answer[-1] == '.' :
#         if answer == '.':
#             answer = ''
#         else:
#             answer = answer[:-1]
    
#     if answer == '':
#         answer = 'a'
    
#     if len(answer) > 15:
#         answer = answer[:15]
#         while len(answer) > 0 and answer[-1] == '.' :
#             if answer == '.':
#                 answer = ''
#             else:
#                 answer = answer[:-1]

#     while len(answer) <= 2:
#         answer += answer[-1]    
    
#     return answer