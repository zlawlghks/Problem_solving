def solution(s):
    answer = ''
    s_list = list(s)
    s_list.sort(reverse = True)
    answer = "".join(s_list)
    return answer