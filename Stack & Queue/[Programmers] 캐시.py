def solution(cacheSize, cities):
    answer = 0
    cache = []
    
    if cacheSize == 0:
        return 5 * len(cities)
    
    for city in cities:
        city = city.lower()
        if city not in cache:
            answer += 5
            if len(cache) < cacheSize:
                cache.append(city)
            else:
                del cache[0]
                cache.append(city)
        else:
            del cache[cache.index(city)]
            cache.append(city)     
            answer += 1       
    
    return answer