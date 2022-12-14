class MyHashMap:

    def __init__(self):
        self.obj = dict()

    def put(self, key: int, value: int) -> None:
        self.obj[key] = value

    def get(self, key: int) -> int:
        if key in self.obj : 
            return self.obj[key] 
        else:
            return -1

    def remove(self, key: int) -> None:
        if key in self.obj:
            del self.obj[key]

# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)