def solution(arr, divisor):
    answer = []
    idx = 0
    for i in arr:
        if i % divisor == 0:
            answer.insert(idx, i)
            idx += 1
    if(idx == 0):
        answer.insert(0, -1)
    else:
        answer.sort()
    return answer