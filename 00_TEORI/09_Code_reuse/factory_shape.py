class ShapeFactory :
    @staticmethod
    def get_shape(shape_type):
        if shape_type == "circle":
            return Circle()
        elif shape_type == "square":
            return Square()
        elif shape_type == "rectangle":
            return Rectangle()
        else:
            raise ValueError("Unknown shape type")

print("ShapeFactory: Created a new shape of type:", shape_type)