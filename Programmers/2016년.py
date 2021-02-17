import datetime
def solution(a, b):
    answer = ['MON', 'TUE', 'WED', 'THU', 'FRI', 'SAT', 'SUN']
    num = datetime.date(2016, a, b).weekday()
    return answer[num]