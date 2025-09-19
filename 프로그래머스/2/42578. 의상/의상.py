def solution(clothes):
    answer = 0
    
    clothesHash = dict()
    
    for clothe in clothes:
        if clothe[1] in clothesHash:
            clothesHash[clothe[1]].append(clothe[0])
        else:
            clothesHash[clothe[1]] = [clothe[0]]
    
    answer = 1
    
    for itemList in clothesHash.values():
        answer *= len(itemList) + 1
        
    
    return answer-1